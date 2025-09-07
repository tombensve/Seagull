# Architecture

## Messaging

I have now concluded that to do the things I want then there
has to be a common "bus" that all senders and receivers connect
to. The different protocols also connect to the buss. The different
protocols connect to the bus also. The bus actually does not have
any connection to the outside world, but can only be communicated
with from the outside world via provided protocols connected
to the bus.

The Bus should use the Router to determine where to send 
messages.

I clearly did not break this down enough the first time! 
Maybe I still haven't! I'll have to see. I clearly did not
follow the rule that everything should have one and only
one responsibility! 
