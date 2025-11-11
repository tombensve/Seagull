# External

This package contains interfaces that provides an API for needed
functionality that can be provided by an external library or libraries.

No external libraries are made available directly by adding a dependency 
to them! This is a principle for Seagull and other projects I might 
do from now on. 

This comes from experience! I, many years ago worked on a public
site where we were many developers, and all those tended to pull in
their favorite libraries so that in the end there were several 
doing basically the same thing!! This  started to annoy me! I wish 
I had come up with this rather trivial idea then :-). Now when I'm 
only hobby coding it is only me, but I decided to make things very 
clear and flexible anyhow. 

So external library provided functionality is only provided by
an interface that defines the functionality, and an internal 
library depends on the external one and implements the required
API using the external library. 

This makes it completely exchangeable with something else that
wraps another library or libraries, providing the same API.

Only external wrappers have dependencies to external code! Internal
code always uses the defined API. This prevents multiple
dependencies providing same functionality!

External library wrapper APIs should only handle one type
of functionality. If the wrapped library does a lot of different
things then make separate APIs for each functionality used. 
