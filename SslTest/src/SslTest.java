
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;




/**
 * Check the revocation status of a public key certificate using a CRL.
 *
 * NOTE: it only works with V1 CRLs
 */

public class SslTest {

    public String url1;
    public URL url;
    public HttpsURLConnection connection;
    public X509Certificate[] certs;
    String url2;
    
    
    
    public String getAlgorithm() throws IOException
        {
            try
        {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

            X509Certificate certificate = certs[0];

            byte[] crlDistributionPointDerEncodedArray = certificate.getExtensionValue(Extension.cRLDistributionPoints.getId());

            ASN1InputStream oAsnInStream = new ASN1InputStream(new ByteArrayInputStream(crlDistributionPointDerEncodedArray));
            ASN1Primitive derObjCrlDP = oAsnInStream.readObject();
            DEROctetString dosCrlDP = (DEROctetString) derObjCrlDP;

            oAsnInStream.close();

            byte[] crldpExtOctets = dosCrlDP.getOctets();
            ASN1InputStream oAsnInStream2 = new ASN1InputStream(new ByteArrayInputStream(crldpExtOctets));
            ASN1Primitive derObj2 = oAsnInStream2.readObject();
            CRLDistPoint distPoint = CRLDistPoint.getInstance(derObj2);

            oAsnInStream2.close();

            List<String> crlUrls = new ArrayList<String>();
            
            for (DistributionPoint dp : distPoint.getDistributionPoints())
            {
                DistributionPointName dpn = dp.getDistributionPoint();
                // Look for URIs in fullName
                if (dpn != null)
                {
                    if (dpn.getType() == DistributionPointName.FULL_NAME)
                    {
                        GeneralName[] genNames = GeneralNames.getInstance(dpn.getName()).getNames();
                        // Look for an URI
                        for (int j = 0; j < genNames.length; j++)
                        {
                            if (genNames[j].getTagNo() == GeneralName.uniformResourceIdentifier)
                            {
                                String url = DERIA5String.getInstance(genNames[j].getName()).getString();
                                crlUrls.add(url);
                            }
                        }
                    }
                }
            }

            for (String url : crlUrls)
                url2 = url;
                System.out.println(url);
            
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
          return "";  
        }
    
            public void print () throws MalformedURLException, IOException {
            
        url = new URL("https://www.google.co.uk");
        connection = (HttpsURLConnection) url.openConnection();
        connection.connect();        
        certs = (X509Certificate[])connection.getServerCertificates();// #1 

} 
            public String crl() throws MalformedURLException, IOException, CRLException, CertificateException
            {
                CertificateFactory certFactory;
        
 
            certFactory = CertificateFactory.getInstance("X.509");
            URL crlURL = new URL("http://crl.pki.goog/GTSGIAG3.crl");
            InputStream crlStream = crlURL.openStream();
            X509CRL crl = (X509CRL) 
            certFactory.generateCRL(crlStream);
            System.out.println(crl.getCriticalExtensionOIDs());
            return "true";
            }
            
    public static void main(String[] args) throws FileNotFoundException, IOException, CRLException, CertificateException, CertificateException {
	SslTest s = new SslTest();
        //s.print();
        
        String crl = s.crl();
}
}
