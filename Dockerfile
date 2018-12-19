FROM ubuntu:18.10
MAINTAINER Kok How, Teh <funcoolgeek@gmail.com>
# Install dependencies
RUN apt update -y
RUN apt upgrade -y
RUN apt install -y wget sudo libasound2 systemd ufw kmod linux-image-$(uname -r) python curl iptables
RUN wget -q -c --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/11.0.1+13/90cf5d8f270a4347a95050320eef3fb7/jdk-11.0.1_linux-x64_bin.deb -P /tmp
RUN dpkg -i /tmp/jdk-11.0.1_linux-x64_bin.deb
RUN update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-11.0.1/bin/java 2
RUN update-alternatives --config java
RUN update-alternatives --install /usr/bin/jar jar /usr/lib/jvm/jdk-11.0.1/bin/jar 2
RUN update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk-11.0.1/bin/javac 2
RUN update-alternatives --set jar /usr/lib/jvm/jdk-11.0.1/bin/jar
RUN update-alternatives --set javac /usr/lib/jvm/jdk-11.0.1/bin/javac
RUN useradd -r -m -U -d /opt/tomcat -s /bin/false tomcat
RUN wget -q http://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.14/bin/apache-tomcat-9.0.14.tar.gz -P /tmp
RUN tar xf /tmp/apache-tomcat-9*.tar.gz -C /opt/tomcat
RUN rm -f /tmp/*
RUN ln -s /opt/tomcat/apache-tomcat-9.0.14 /opt/tomcat/latest
RUN chown -RH tomcat: /opt/tomcat/latest
RUN chmod o+x /opt/tomcat/latest/bin
ADD tomcat.service /etc/systemd/system/tomcat.service
ADD manager_context.xml /opt/tomcat/latest/webapps/manager/META-INF/context.xml
ADD host-manager_context.xml /opt/tomcat/latest/webapps/host-manager/META-INF/context.xml
RUN rm -rf /opt/tomcat/latest/webapps/docs /opt/tomcat/latest/webapps/examples
RUN systemctl enable tomcat
RUN systemctl enable ufw
RUN apt autoremove
ADD target/restapi /opt/tomcat/latest/webapps/restapi
RUN chown -R tomcat:tomcat /opt/tomcat/latest/webapps/restapi
EXPOSE 22 8080 443
#ENTRYPOINT [“java”,”-Djava.security.egd=file:/dev/./urandom”,”-jar”,”/HelloRestAPI-0.0.1-SNAPSHOT.jar”]
CMD ["/opt/tomcat/latest/bin/catalina.sh", "run"]
