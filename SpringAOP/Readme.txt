Spring AOP (Aspect-oriented programming) framework helps to decouple cross-cutting 
concerns form the objects that they affect.Using Spring framework cross-cutting concerns
can now be modularized into special objects called "Aspects"

Advice
======
Aspects have a purpose- a job that they are meant to do.In AOP the job of an aspect
is called "advice". Advice defines both "what" and "when" of an aspect.
"what" : what is the job 
"when" : when to perform job. Should it apply before or after method invoke?

joinpoint
=========
Your application may have thousands of opportunities for advice to be applied.These opportunities
are known "joinpoints". So a joinpoint is a point in the execution of the application where
an aspect can be plugged in.

pointcut
========
A subset of joinpoint actually needs to be advised by an aspect. If advice defines "what" and "when"
of aspects then pointcut defines the "where".

Aspect
======
Aspect = advice + pointcut;

Target
======
A target is the object that is being adviced. Without AOP this object would have to contain
its primary logic + cross-cutting concerns. With AOP traget object is free to focus on its primary logic.

Proxy
=====
A proxy is the object created after applying advice to the target object. As far as outside client objects are
concerned , the target object (pre-AOP) and the proxy object(post-AOP) are the same .

***************************************************************************************
Use necessary jars in Spring/lib folder
*************************************************************************************** 