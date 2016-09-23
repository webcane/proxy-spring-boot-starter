# proxy-spring-boot-starter
spring boot starter for http proxy

### RU
spring boot приложению может понадоиться работать с удаленным сервисом. Это не всегда возможно сделать напрямую. Решением может послужить - использование proxy. Автоконфигуратор позволяет упростить этот процесс:

1. добавить в application.properties следующие параметры
```properties
    proxy.host=proxy.myhost.ru
    proxy.port=3128
```
2. добавить maven зависимость 
```xml
      <dependency>
          <groupId>cane.brothers.spring</groupId>
			    <artifactId>http-proxy-starter</artifactId>
			    <version>1.0.0</version>
      </dependency>
```
3. Вызвать в нужном месте объект ICanProxy
```java
@Component
public class MyStartupListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired(required = false)
	private ICanProxy systemProxy;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if(systemProxy != null) {
			systemProxy.configure();
		}
		doSomeWork();
	}
```

Если в файле конфигурации не будут найдены `proxy.host` и `proxy.port` параметры, то не будет сконфигурирован объект для ICanProxy.
В контексте приложения его не будет. `required = false` не выдаст в этом случае исключение. Что позволит игнорировать подключенный модуль для proxy.
