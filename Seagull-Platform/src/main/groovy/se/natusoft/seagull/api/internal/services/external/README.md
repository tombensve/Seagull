# External

This package contains interfaces that provides an API for needed
functionality that can be provided by an external library or libraries.

No external libraries are made available directly by adding a dependency
to them! This is a principle for Seagull and other projects I might
do from now on.

This comes from experience! I, many years ago worked on a public
site where we were many developers, and all those tended to pull in
their favorite libraries so that in the end there were several
doing basically the same thing!! This started to annoy me! I wish
I had come up with this rather trivial idea then :-). Now when I'm
only hobby coding it is only me, but I decided to make things very
clear and flexible anyhow.

So external library provided functionality is only provided by
an interface that defines the functionality needed by the code.

So to pull in an external library, a new module is created,
and code that implements appropriate interface using functionality
in library iss created. This module is the only one having
any contact with external library which is added as a
dependency to the external library.

This means no other code have access to external library in any
way. This means the library can be exchanged with another
library providing same functionality, but might dop tings
better.The rest of the application uses the official interface
to access functionality, and will thereby not be affected
by library change. Even internally interfaces are used a lot
to provide flexibility.
