
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

This is intended to be a very simple to use service platform where services does not have to deal directly with protocols like REST, plain TCP/IP, data buses (like Rabbit MQ), carrier pigeon, ... 

I have spent a lot of time thinking this through, and want to keep things as simple as possible from service development perspective, and in general! My point here is that this says nothing about how information goes from point A to point B. 

## Goals

- Small.
- Trivial to use.
- Supporting multiple protocols of communication.
- A service deployable should be runnable with java -jar do.main.MyService.jar
- (Auto discovery.)

----
For greater flexibility IMHO, the API does not contain any GET/PUT/SCREW-UP/etc. It is up to each service to understand what it should do.  

I leave it up to developers to abuse things in any way they want! I will not make things extremely strict and limited, just to steer people who does not know what they are doing. Put on a blindfold, swing sharp objects, and run fast! I'm not going to stop you!

----

# Groovy

It is done to 100% in Groovy (JVM) and will use Closures, which does not exist in Java (looks like lambdas, definitely aren't!) See <https://groovy-lang.org/closures.html>). That said, I have decided to define these as a single method interface and when used a closure will be coerced onto this interface. This will clearly define both in type and out type. This also makes it possible to use from Java.

You can actually create a class within a method that implements the interface in Java. This is what Groovy does when compiling closures. It just looks weirder and harder to read in Java.

## Models

I have decided to define all models as interfaces using [NSToolbox/Modelish](https://github.com/tombensve/NS-Toolbox/tree/main/Modelish), another of my projects at GitHub).

These provide features like immutability, but also stores all data in a Map structure that basically is a JSON structure that can easily be converted to JSON. It is also possible to convert incoming JSON to a Map structure and set it on a Modelish model which will handle sub models also automatically. 

Since models are interfaces I provide factories to create instances. These factories are local to Seagull and offers 
more flexibility in creating instances by finding implementations. Basically Seagull wraps original factory for 
getting model implementations so that becomes an under the surface action, making things replaceable with lower
risk of breaking code.

_Example of using a Seagull model factory_

`SGJson sgJson = SGJsonFactory.use.newSgJson()`.

# Types

I have decided to make things very non-strict! 

For example, here is an example of calling a service:

    send( String to, String from, String type, ... ) 

There is something that I have been rolling around in my head quite a lot, having a problem
to make a decision! This has been really annoying!

But  as you see above, a decision have been made!! 

To be able to determine what the data being sent or received, a simple unique name
is used!!



-------

So services are represented by plain string names! Thereby they need to be unique! Seagull does not
ensure that in any way! As in the example above even the type of the data the service expects and
returns are named in a String! Nothing is enforced! It is fully possible to pass bad data for these
and that will in best case make things fail! 

I suggest making named constants to lessen the risk of typos.

The same goes for types! Each service must know the data structure of the message based on
the named type!

----

If you read the code and wonder about the empty lines and // ~~~~... // dividers, I need it 
for my brain to be able to interpret what it looks at! Even with glasses I have visual problems!

----

(Above text art from <https://textkool.com/en/test-ascii-art-generator?text=Seagull>)
