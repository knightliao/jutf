jutf 
=======

[![Apache License 2](https://img.shields.io/badge/license-ASF2-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.txt)
[![Build Status](https://travis-ci.org/knightliao/jutf.svg?branch=master)](https://travis-ci.org/knightliao/jutf) 
[![Coverage Status](https://coveralls.io/repos/github/knightliao/jutf/badge.svg?branch=master)](https://coveralls.io/github/knightliao/jutf?branch=master) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.knightliao.test/jutf/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/com.github.knightliao.test/jutf) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.knightliao.test/jutf-spring/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/com.github.knightliao.test/jutf-spring)

Java Unit Test Framework (Warp H2/Mockito/jmockit tools to make java application better) 

一个非常好用的Java单元测试框架。
 
## Func

- jutf(spring free dependency version)
    - Use mockito/jmockit to mock interface 
    - Utils to mock get/set/construct/tostring
    - H2 Memory Test db utils
    - log message checker 
- jutf-Spring(spring dependency version)
    - Use mockito/jmockit to mock interface 
    - Utils to mock get/set/construct/tostring
    - H2/Mysql Test db utils
    - log message checker 
    
## Quick Start

doc: http://jutf.readthedocs.io/en/latest/

## Maven

### jutf

    <dependency>
        <groupId>com.github.knightliao.test</groupId>
        <artifactId>jutf</artifactId>
        <version>1.0.3</version>
    </dependency>
    
### jutf-Spring

    <dependency>
        <groupId>com.github.knightliao.test</groupId>
        <artifactId>jutf-spring</artifactId>
        <version>1.0.3</version>
    </dependency>
    
