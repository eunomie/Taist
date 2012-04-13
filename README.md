Eunomie
=======

Description
-----------

Eunomie is an experimentation of web application using
cool technologies like :

* guice (DI)
* guice-servlet and jersey-guice
* jetty
* gradle
* gson
* closure tools

At this time, purpose of the project is not clearly defined, the goal
is essentially to be fun.
Perhaps a kind of web plateforme, used to replace my blog and "delicious clone".

Two points to mention :

* the application will be fast
* the application will be fast (yeah!)
* the application will produce plain html(5) with javascript progressive enhancement.


External dependencies
---------------------

Due to some size limitations on my primary repository, external dependencies are not
include in the distribution.
This is not yet (at this revision) necessary, but further external dependencies must
be added at hand in the lib/ directory. This is for dependencies not available in
maven central.

* lib/soy.jar

Soy can be build using https://github.com/CrEv/closure-templates. This is a fork of
the official svn repository. This version only contains an upgrade of the guava
dependency to be compatible with main code.