## 一、前言

**Why? **

**国际化？**

**到底什么是国际化？**

**国际化：**是根据访问网站的地区展示不同的语言、时间等

比如：在美国访问网站，网站内容就变成英文

​           在中国访问，网站内容就变成中文

​           在中国台湾访问，网站内容就变成繁体

英文翻译过来，国际化叫做**internationalization**，但是因为内容太长，所以可以简称 **i18n**，你也可以数一下，i和n之间一共有18个字母，所以简称为 **i18n**

我们正式开始，介绍如何在Springboot中使用国际化

## 二、国际化Coding

### 2.1 依赖

我们只需要引入web的依赖，就可以支持国际化

```xml
 <dependency>
      <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
 </dependency>
```

### 2.2 编写配置文件

我们在这里需要创建配置文件，因为我们使用中文、英文，所以我们需要在Resource中创建三个文件：

- messages.properties
- messages_en_US.properties               英文环境
- messages_zh_CN.properties               中文环境

> messages_en_US.properties  

```yaml
user.name=yangzinan
```

> messages_zh_CN.properties 

```
user.name=杨子楠
```

### 2.3 创建接口，进行测试

```java
@RestController
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/message")
    public String message(){
        //获取消息
        String message = messageSource.getMessage("user.name", 
                                                  null, 
                                                  LocaleContextHolder.getLocale());
        return message;
    }

}
```

我们首先看，我们请求的时候，请求头会有其中的一个字段

```
#表示我们的语言为中文
Accept-Language: zh-CN;
```

所以我们使用的配置文件是：**messages_zh_CN.properties**

如果我们使用POSTMAN来进行测试，那么就需要配置**Header**：

```bash
#调用messages_zh_CN.properties配置文件，返回杨子楠
Accept-Language     zh-CN  

#调用messages_zh_CN.properties配置文件，返回yangzinan
Accept-Language     en-US                  
```

国际化内容已经结束，快动手尝试一下！