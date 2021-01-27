package uk.nhs.nhsx.diagnosiskeydist.keydistribution;

import com.google.common.io.ByteSource;
import org.apache.http.entity.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.nhs.nhsx.core.aws.s3.BucketName;
import uk.nhs.nhsx.core.aws.s3.Locator;
import uk.nhs.nhsx.core.aws.s3.ObjectKey;
import uk.nhs.nhsx.core.aws.s3.S3Storage;
import uk.nhs.nhsx.core.signature.DatedSignature;
import uk.nhs.nhsx.core.signature.DatedSigner;
import uk.nhs.nhsx.core.signature.DistributionSignature;
import uk.nhs.nhsx.core.signature.SigningHeaders;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.asByteSource;

public class UploadToS3KeyDistributor implements KeyDistributor {

    private static final Logger logger = LogManager.getLogger(UploadToS3KeyDistributor.class);

    private final S3Storage s3Storage;
    private final DatedSigner signer;

    public UploadToS3KeyDistributor(S3Storage s3Storage, DatedSigner signer) {
        this.s3Storage = s3Storage;
        this.signer = signer;
    }

    @Override
    public void distribute(BucketName name, ObjectKey key, File binFile, File sigFile) throws IOException {
        File zipFile = File.createTempFile("export", ".zip");

        try {
            KeyFileUtility.zipFiles(zipFile, binFile, sigFile);
            ByteSource byteSource = asByteSource(zipFile);

            DatedSignature signatureResult = signer.sign(new DistributionSignature(byteSource));

            s3Storage.upload(
                Locator.of(name, key),
                ContentType.create("application/zip"),
                byteSource,
                SigningHeaders.fromDatedSignature(signatureResult)
            );
        } finally {
            boolean ok = zipFile.delete();
            if (!ok) logger.warn("Could not delete {}", zipFile.getAbsolutePath());
        }
    }
}
