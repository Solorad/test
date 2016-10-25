/**
 * @author emorenkov
 */
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.io.File;


@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
    private Property property;

    public Property getPropertyObject() {
        return property;
    }

    public void setPropertyObject(Property property) {
        this.property = property;
    }

    @XmlRootElement(name = "Property")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Property {
        @XmlAttribute(name = "Key")
        private String key;
        @XmlValue
        private String text;

        public String getKeyObject() {
            return key;
        }

        public void setKeyObject(String key) {
            this.key = key;
        }

        public String getValueObject() {
            return text;
        }

        public void setValueObject(String value) {
            this.text = value;
        }
    }

    public static void main(String[] args) throws JAXBException {
        Root root = new Root();
        Property property = new Property();
        property.setKeyObject("dsfdsf");
        property.setValueObject("val");
        root.setPropertyObject(property);
        File file = new File("C:\\file.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(root, file);
        jaxbMarshaller.marshal(root, System.out);
    }
}
