package se.natusoft.seagull

import org.junit.jupiter.api.Test
import se.natusoft.seagull.api.model.SGMessageId

class SGMessageIdTest {
    
    @Test
    void testIDUsage() throws Exception {
        
        SGMessageId msgId = new SGMessageId()
        
        println "--------------------> " + msgId
        
        throw new RuntimeException("==========================")
    }
}
