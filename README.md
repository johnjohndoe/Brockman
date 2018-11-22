[![Build Status](https://travis-ci.org/johnjohndoe/Brockman.svg)](https://travis-ci.org/johnjohndoe/Brockman) [![Apache License](http://img.shields.io/badge/license-Apache%20License%202.0-lightgrey.svg)](http://choosealicense.com/licenses/apache-2.0/)

# Brockman library

![Brockman logo](gfx/brockman-logo.png "Brockman logo")

A Java library containing a parser and models for the streaming media API of the CCC available here:

* https://streaming.media.ccc.de

This library is named after [*Kent Brockman*][kent-brockman-wikipedia], the news anchor from *The Simpsons*.


## Demo application

Please note there is an Android demo application for this library available:

* https://github.com/johnjohndoe/BrockmanDemo


## Usage

The library can be accessed via the `ApiModule` class.

```java
StreamsService streamsService = ApiModule.provideStreamsService("https://streaming.media.ccc.de");

Call<List<Offer>> getOffersCall = service.getOffers("/streams/v2.json");
// Execute getOffers call to send a request to the webserver.
```

Since the CCC streaming media API is only online at the time of the conference
the following static JSON response might be handy for development and debugging:

```java
StreamsService streamsService = ApiModule.provideStreamsService("https://gist.githubusercontent.com");

Call<List<Offer>> getOffersCall = service.getOffers(
    "/johnjohndoe/617bbfa2ac36f5148a049548b419e299/raw/7ab4e206f19ed4d63a67917fe6e3a15a96218ac9/streams-v2.json");
// Execute getOffers call to send a request to the webserver.
```


### Gradle build

To deploy the library to your local Maven repository run the following task:

```bash
$ ./gradlew publishToMavenLocal
```

Then, to use the library in your project add the following to
your top level `build.gradle`:

```
allprojects {
    repositories {
        jcenter()
        mavenLocal()
    }
}
```

and to your application module `build.gradle`:


```groovy
dependencies {
    compile "info.metadude.java.library.brockman:brockman-library:${version}"
}
```

Alternatively, you can use [JitPack][jitpack] to fetch and build the sources
directly from this repository.
Therefore, add JitPack to your top level `build.gradle`:

```groovy
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

and then reference the library project in your application module `build.gradle`:

```groovy
dependencies {
    compile "com.github.johnjohndoe:Brockman:${hash}"
}
```

The `{$hash}` can be a branch name such as `master` or an actual commit hash.


## Tests

Run the following command to execute all tests:

```groovy
$ ./gradlew clean test
```


## Author

* [Tobias Preuss][tobias-preuss]

## License

    Copyright 2015 - 2018 Tobias Preuss

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[tobias-preuss]: https://github.com/johnjohndoe
[kent-brockman-wikipedia]: https://en.wikipedia.org/wiki/Kent_Brockman
[jitpack]: https://jitpack.io
