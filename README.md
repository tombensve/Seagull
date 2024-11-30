
----
      >=>>=>                                             >=>  >=> 
    >=>    >=>                                           >=>  >=> 
     >=>         >==>       >=> >=>     >=>    >=>  >=>  >=>  >=> 
       >=>     >>   >=>   >=>   >=>   >=>  >=> >=>  >=>  >=>  >=> 
          >=>  >>===>>=> >=>    >=>  >=>   >=> >=>  >=>  >=>  >=>
    >=>    >=> >>         >=>   >=>   >=>  >=> >=>  >=>  >=>  >=> 
      >=>>=>    >====>     >==>>>==>      >=>    >==>=> >==> >==> 
                                   >=>                
----

![](pics/SeaGull-small.png)

(Local individual)

_I suck at coming upp with names, and a seagull just flew by my balcony ..._

_Seagulls are also apparently quite smart, and have equality between male and female. They are also amazing flyers that can navigate air streams without visibly moving their wings._

-----

# So, what is this about ?

It is about information flying around between different services, triggering things to be done, in simple terms.

**NOTE:** This is my reboot / rethinking of my APS project and is like APS a playground where I'm having fun, and stimulating my brain.

This is intended to be a very simple to use service platform.

## Goals

- Small.
- Trivial to use.
- Supporting multiple protocols of communication.
- A service deployable should be runnable with java -jar MyService.jar
- (Auto discovery.)

For greater flexibility IMHO, messages will not contain any specific CRUD information. I leave it up to 
service implementations to handle such if needed. 

# Groovy

It is done to 100% in Groovy (JVM) and will use Closures, which does not exist in Java (looks like lambdas, definitely aren't!) See <https://groovy-lang.org/closures.html>). That said, I have decided to define these as a single method interface and when used a closure will be coerced onto this interface. This will clearly define both in type and out type. This also makes it possible to use from Java.

You can actually create a class within a method that implements the interface in Java. This is what Groovy does when compiling closures. It just looks weirder and harder to read in Java.

## Models

I have decided to define all models as interfaces using [NSToolbox/Modelish](https://github.com/tombensve/NS-Toolbox/tree/main/Modelish), another of my projects at GitHub).

These provide features like immutability, but also stores all data in a Map structure that  basically is a JSON structure that can easily be converted to JSON. It is also possible to convert incoming JSON to a Map structure and set it on a Modelish model which will delegate to sub models.

Since they are interfaces I provide factories to create instances. These factories are local to Seagull and offers more flexibility in creating instances by implementations.

_Example of using a Seagull model factory_

`SGJson sgJson = SGJsonFactory.use.newSgJson()`.

----

(Above text art from <https://textkool.com/en/test-ascii-art-generator?text=Seagull>)
