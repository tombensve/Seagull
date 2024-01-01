
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

_Seagulls are also apparently quite smart, and have equality between male and female. They are also amazing flyers that
can navigate air streams without visibly moving their wings._

-----

# So, what is this about ?

It is about information flying around between different services, triggering things to be done, in simple terms.

**NOTE:** This is my reboot / rethinking of my APS project and is like APS a playground where I'm having fun, and
stimulating my brain.

A sub goal is to keep things very simple, though not by pretending something is something it really isn't!

# Decisions

- It is done to 100% in Groovy and will use Closures, which does not exist in Java (looks like lambdas, definitely
aren't! See <https://groovy-lang.org/closures.html>).

## Models

I have decided to define all models as interfaces and use 
[NSToolbox/Modelish](https://github.com/tombensve/NS-Toolbox/tree/main/Modelish), another of my projects at GitHub) 
These provide features like immutability, but also stores all data in a Map structure that
basically is a JSON structure that can easily be converted to JSON. It is also possible to convert 
incoming JSON to a Map structure and set it on a Modelish model which will delegate to sub models.

Since they are interfaces I provide factories to create instances. These factories are local to 
Seagull and offers more flexibility in creating instances by implementations.

_Example of using a Seagull model factory_

`SGJson sgJson = SGJsonFactory.use.newSgJson()`.

----

(Above text art from <https://textkool.com/en/test-ascii-art-generator?text=Seagull>)
