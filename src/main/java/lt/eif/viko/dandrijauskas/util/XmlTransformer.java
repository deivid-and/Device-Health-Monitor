package lt.eif.viko.dandrijauskas.util;

import lt.eif.viko.dandrijauskas.model.Device;
import lt.eif.viko.dandrijauskas.model.DevicesList;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * utility class for exporting xml, transforming to html/pdf.
 */

public class XmlTransformer {

    // export device list to xml file
    public void exportDevicesToXml(List<Device> devices, String filePath) {
        try {
            DevicesList wrapper = new DevicesList();
            wrapper.setDevices(devices);

            JAXBContext context = JAXBContext.newInstance(DevicesList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(wrapper, new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // transform xml to html using xslt
    public void transformXmlToHtml(String xmlPath, String xslPath, String htmlOutputPath) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            StreamSource xsl = new StreamSource(new File(xslPath));
            Transformer transformer = factory.newTransformer(xsl);

            StreamSource xml = new StreamSource(new File(xmlPath));
            StreamResult html = new StreamResult(new File(htmlOutputPath));

            transformer.transform(xml, html);
            System.out.println("Transformed XML to HTML: " + htmlOutputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // transform xml to pdf using xsl-fo and fop
    public void transformXmlToPdf(String xmlPath, String xslFoPath, String pdfOutputPath) {
        try {
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            OutputStream out = new FileOutputStream(pdfOutputPath);
            try {
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(new File(xslFoPath)));

                StreamSource src = new StreamSource(new File(xmlPath));
                SAXResult res = new SAXResult(fop.getDefaultHandler());

                transformer.transform(src, res);
                System.out.println("PDF generated: " + pdfOutputPath);
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
