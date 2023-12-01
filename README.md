
----
<pre>
  >=>>=>                                             >=>  >=> 
>=>    >=>                                           >=>  >=> 
 >=>         >==>       >=> >=>     >=>    >=>  >=>  >=>  >=> 
   >=>     >>   >=>   >=>   >=>   >=>  >=> >=>  >=>  >=>  >=> 
      >=>  >>===>>=> >=>    >=>  >=>   >=> >=>  >=>  >=>  >=> 
>=>    >=> >>         >=>   >=>   >=>  >=> >=>  >=>  >=>  >=> 
  >=>>=>    >====>     >==>>>==>      >=>    >==>=> >==> >==> 
                                   >=>                
</pre>
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

It is done to 100% in Groovy and will use Closures, which does not exist in Java (looks like lambdas, definitely
aren't! See <https://groovy-lang.org/closures.html>).

I have decided to define all models as interfaces and use `SGModelFactory.use.newSomething()` to create 
instances. This will allow me to use my Modelish models from NSToolbox, but without forcing it. This allows
for any implementation of SGModelFactory, producing any type of models as long as they implement the model
API. 

_Why ?_ Because this is more of a challenge! My goal is to make things as simple, clean and as small as I can
without loosing flexibility. It is intended to be a challenge, which also makes it more fun! 

----

_Note_ that all development tasks were in my personal YouTrack instance since I **used to think** that YouTrack was
so much nicer. 

I took the fight again to make communication between YouTrack and IDEA work, but finally gave upp! So I had to 
copy all my YouTrack issues to GitHub again, after having copied the Github ones to YouTrack, and deleted them 
in Github. YouCrap is now dead to me!

That said, I'm starting to really like the _GitHub Projects_ now! You can create issues for each card, and you
can manage these issues within the project view. Idea will se the issues for Tasks management. Maybe this
integration is made by GitHub and not JetBrains. 

----

(Above art from <https://textkool.com/en/test-ascii-art-generator?text=Seagull>)