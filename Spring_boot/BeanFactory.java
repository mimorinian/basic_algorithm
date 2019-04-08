public interface BeanFactory {

    /**
     * 用来获取FactoryBean本身的转义符
     */
    String FACTORY_BEAN_PREFIX = "&";

    /**
     * 获取容器维护的bean是用名称来指定的
     */
    Object getBean(String name) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(Class<T> requiredType, Object... args) throws BeansException;

    /**
     * 查看容器中是否包含指定name的bean
     */
    boolean containsBean(String name);

    /**
     * 判断指定name的bean是否为单例
     */
    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

    /**
     * 判断指定name的bean是否为多例
     */
    boolean isPrototype(String name) throws NoSuchBeanDefinitionException;

    boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;

    boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException;

    Class<?> getType(String name) throws NoSuchBeanDefinitionException;

    /**
     * 获得bean的所有别名
     */
    String[] getAliases(String name);

}