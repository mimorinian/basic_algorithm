public class FileSystemXmlApplicationContext extends AbstractXmlApplicationContext {
    public FileSystemXmlApplicationContext() {
    }
    public FileSystemXmlApplicationContext(ApplicationContext parent) {
        super(parent);
    }
    public FileSystemXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[] {configLocation}, true, null);
    }
    public FileSystemXmlApplicationContext(String... configLocations) throws BeansException {
        this(configLocations, true, null);
    }
    public FileSystemXmlApplicationContext(String[] configLocations, ApplicationContext parent) throws BeansException {
        this(configLocations, true, parent);
    }
    public FileSystemXmlApplicationContext(String[] configLocations, boolean refresh) throws BeansException {
        this(configLocations, refresh, null);
    }

    /**
     * setConfigLocations 将路径字符串解析到自己存资源配置的configLocations里
     * 然后调用refresh()，这也是容器初始化的入口
     * 
     */
    public FileSystemXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
            throws BeansException {

        super(parent);
        setConfigLocations(configLocations);
        if (refresh) {
            refresh();
        }
    }

    /**
     * 这是这个FileSystemXml自己的实现部分，getResourceByPath必然是哪一个父类模版方法需要调用的方法
     * 而这个方法自己实现提供一个FileSystemResource出来。
     * Resource这个就是将元数据转化成容器可以统一可以解析的资源，根据不同的元数据类型，必然需要不同的算法去读取这些数据。
     */
    @Override
    protected Resource getResourceByPath(String path) {
        if (path != null && path.startsWith("/")) {
            path = path.substring(1);
        }
        return new FileSystemResource(path);
    }

}