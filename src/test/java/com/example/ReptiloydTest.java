package com.example;

import org.junit.Test;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class ReptiloydTest 
{
    
    /*Задание 1*/
    @Test
    public void createdHumanTest()
    {
        Reptiloyd reptiloyd = new Reptiloyd();
        assertEquals("Human created", reptiloyd.createdHuman());
        assertEquals("The human has already been created", reptiloyd.createdHuman());
    }

    @Test
    public void isDeadTest()
    {
        Reptiloyd reptiloyd = new Reptiloyd();
        assertFalse(reptiloyd.isDead());
        reptiloyd.dead();
        assertTrue(reptiloyd.isDead());
    }

    @Test
    public void humanIsDeadTest()
    {
        Reptiloyd reptiloyd = new Reptiloyd();
        reptiloyd.createdHuman();
        assertFalse(reptiloyd.humanIsDead());
        reptiloyd.humanDead();
        assertTrue(reptiloyd.humanIsDead());

    }
    
    /*Задание 2*/
    @Test
    public void spiedCreatedHumanTest() {
        Reptiloyd testedClass = mock(Reptiloyd.class);
        testedClass.createdHuman();
        verify(testedClass, times(1)).createdHuman();
    }
    
    /*Задание 3 */
    @Test(expected = LimitedCloneException.class)
    public void testedMethodTest() throws LimitedCloneException {
        Reptiloyd testedClass = mock(Reptiloyd.class);
        testedClass.createdHuman();  
        when(testedClass.cloneHuman()).thenThrow(new LimitedCloneException("Limited clone"));
        testedClass.cloneHuman();
    }

    /*Задание 4 */
    @Test
    public void privateMethodTest() throws Exception {
        Reptiloyd reptiloyd = new Reptiloyd();
        Method method = Reptiloyd.class.getDeclaredMethod("id");
        method.setAccessible(true);
        assertEquals(123, (int)method.invoke(reptiloyd));
    }

}
