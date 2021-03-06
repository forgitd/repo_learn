# JVM探究

 ![image-20210820084033777](md图片/image-20210820084033777.png)

## 1.jvm体系结构

### 1.1 jvm的位置

> jvm本身也是一个进程

 ![image-20210820084615192](md图片/image-20210820084615192.png)

### 1.2jvm体系结构

 ![image-20210820085049146](md图片/image-20210820085049146.png)

>  ![image-20210820085437792](md图片/image-20210820085437792.png)
>
> GC、解释器在执行引擎中。

### 1.3 类加载器

**回顾面向对象：**

 ![image-20210820093603158](md图片/image-20210820093603158.png)

 ![image-20210820090153499](md图片/image-20210820090153499.png)

> 注意：new 一个对象，对象名字在栈中，使用这个对象时会通过栈中指向堆中的地址去找堆中的数据。
>
> 

**类加载器：**

 ![image-20210820090533543](md图片/image-20210820090533543.png)

>  ![image-20210820091019195](md图片/image-20210820091019195.png)



### 1.4双亲委派机制：

 ![image-20210820091324929](md图片/image-20210820091324929.png)

 ![image-20210820091937271](md图片/image-20210820091937271.png)

 ![image-20210820092057098](md图片/image-20210820092057098.png)

### 1.5 沙箱安全机制

 ![image-20210820092805911](md图片/image-20210820092805911.png)

 基本组件：

![image-20210820093307471](md图片/image-20210820093307471.png)



 ![image-20210820093829647](md图片/image-20210820093829647.png)

### 1.6 native关键字 -- 本地方法栈

 ![image-20210820094155359](md图片/image-20210820094155359.png)

 ![image-20210820094708218](md图片/image-20210820094708218.png)

 ![image-20210820095437587](md图片/image-20210820095437587.png)

### 1.7 PC寄存器

 ![image-20210820095646521](md图片/image-20210820095646521.png)

### 1.8 方法区

 ![image-20210820100630653](md图片/image-20210820100630653.png)

## 2.栈

 ![image-20210820101009191](md图片/image-20210820101009191.png)



### 2.1 为什么main()最先执行，最后结束

 ![image-20210820101310764](md图片/image-20210820101310764.png)

  ### 2.2栈的生命周期



 ![image-20210820101411777](md图片/image-20210820101411777.png)

 ### 2.3 栈存储

 ![image-20210820101505360](md图片/image-20210820101505360.png)

byte + 7

### 2.4 栈原理 -- 栈帧

 ![image-20210820101831503](md图片/image-20210820101831503.png)

### 2.5 栈满

StackOverflowError  -- 



### 2.6 栈 堆 方法区交互

 ![image-20210820102529733](md图片/image-20210820102529733.png)

## 3.堆(heap)

### 3.1 三种JVM

![image-20210820102956707](md图片/image-20210820102956707.png)



### 3.2 heap

 ![image-20210820103144900](md图片/image-20210820103144900.png)

> 调节：main方法运行，idea上面 配置edit configuration
>
> ​           配置vm和程序



 存储：引用类型的真实对象，类，方法，常量，变量![image-20210820103925496](md图片/image-20210820103925496.png)

 ![image-20210820103824908](md图片/image-20210820103824908.png)

 ![image-20210820104449410](md图片/image-20210820104449410.png)

### 3.3 新生区、老年区

 ![image-20210820105331140](md图片/image-20210820105331140.png)

### 3.4 永久区

 ![image-20210820105529364](md图片/image-20210820105529364.png)

  ![image-20210820110239195](md图片/image-20210820110239195.png)

### 3.5 代码测试

 ![image-20210820111526578](md图片/image-20210820111526578.png)

> 

更改默认值：

 -Xmx 最大内存   -Xms 最大运行时内存 （下面的错了）![image-20210820113008050](md图片/image-20210820113008050.png)

 ![image-20210820113049407](md图片/image-20210820113049407.png)

### 3.6 项目OOM故障，如何排查？

 ![image-20210820113345769](md图片/image-20210820113345769.png)

#### MAT，Jprofiler作用：

 ![image-20210820113412508](md图片/image-20210820113412508.png)



#### 安装Jprofiler：

1. 官网下载

    ![image-20210820113830415](md图片/image-20210820113830415.png)

2. 安装插件和jprofiler

    ![image-20210820114024778](md图片/image-20210820114024778.png)

    ![image-20210820114036224](md图片/image-20210820114036224.png)

3. 注册

   没有许可证就用10天

4. executable

    ![image-20210820115248875](md图片/image-20210820115248875.png)

#### 代码测试

1. java代码

   ```java
   import java.util.ArrayList;
   
   public class test01 {
       byte[] bytes = new byte[1 * 1024 * 1024];
       public static void main(String[] args) {
   
           ArrayList<test01> list = new ArrayList<>();
           int count = 0;
   
           try {
               while (true) {
                   list.add(new test01());
                   count = count + 1;
               }
           } catch (Exception e) {
               System.out.println(count);
           }
           // Throwable
               // Exception
               // Error
       }
   }
   
   // oom 错误
   ```

2. 配置

    `-XX:+PrintGCDetails`![image-20210820120730979](md图片/image-20210820120730979.png)

   

3. 运行导出dump文件

    ![image-20210820121657372](md图片/image-20210820121657372.png)

4. 工具分析

    ![image-20210820121725948](md图片/image-20210820121725948.png)

   ​	 ![image-20210820121748244](md图片/image-20210820121748244.png)

 

#### 其它

![image-20210820122018447](md图片/image-20210820122018447.png)



## 4.GC

### 4.1 GC是什么

GC：垃圾回收（garbage collection）

存在于：堆和方法区

 ![image-20210820124330490](md图片/image-20210820124330490.png)

 ![image-20210820124609191](md图片/image-20210820124609191.png)

### 4.2 GC算法

#### 4.2.1 引用计数法

 ![image-20210820124947014](md图片/image-20210820124947014.png)

> 不采用。
>
> 对每个对象设置一个计数器，每用一次就给计数器+1；
>
> 对为0的对象进行清除

#### 4.2.1 复制算法

 ![image-20210820125607198](md图片/image-20210820125607198.png)

 ![image-20210820125902188](md图片/image-20210820125902188.png)

> 新生区：主要使用复制算法
>
> - 好处：没有内存的碎片
> - 缺点：浪费内存空间，有一半空间永远是空的
>
> 最佳使用场景：对象存活度低。 -- 新生区对象存活度低

#### 4.2.3 标记清除算法

 ![image-20210820130358467](md图片/image-20210820130358467.png)

> - 优点：不需要额外的空间
> - 缺点：两次扫描，浪费时间，会产生内存碎片

#### 4.2.4 标记整理（标记压缩）

对标记清除算法的优化

 ![image-20210820130648270](md图片/image-20210820130648270.png)

 

### 4.3 总结

 ![image-20210820130936901](md图片/image-20210820130936901.png)

 ![image-20210820131225184](md图片/image-20210820131225184.png)

## 5.JMM

### 5.1 什么是JMM

Java Memory Model (java内存模型)

作用：缓存一致性协议，用于定义数据读写的规则

 ![image-20210820133321204](md图片/image-20210820133321204.png)

规则：

 ![image-20210820133634422](md图片/image-20210820133634422.png)
