public class XmlBeanFactory extends DefaultListableBeanFactory {
    /**
     * 换了一个reader
     */
    private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);

    public XmlBeanFactory(Resource resource) throws BeansException {
        this(resource, null);
    }


    public XmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
        super(parentBeanFactory);
        this.reader.loadBeanDefinitions(resource);
    }

}
