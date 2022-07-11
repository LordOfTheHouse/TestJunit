package com.example.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import org.junit.Test;

public class ReptiloydTest {

    /* Просто тесты */
    @Test
    public void createdHumanTest() {
        Reptiloyd reptiloyd = new Reptiloyd();
        assertEquals("Human created", reptiloyd.createdHuman());
        assertEquals("The human has already been created", reptiloyd.createdHuman());
    }

    @Test
    public void isDeadTest() {
        Reptiloyd reptiloyd = new Reptiloyd();
        assertFalse(reptiloyd.isDead());
        reptiloyd.dead();
        assertTrue(reptiloyd.isDead()); 
    }

    /* Задание 1 */
    @Test
    public void getHumanNameTest() {
        Human mockB = mock(Human.class);
        doReturn("Georg").when(mockB).getName();
        Reptiloyd reptiloyd = new Reptiloyd();
        reptiloyd.setHuman(mockB);
        assertEquals("Georg", reptiloyd.getHumanName()); 
    }

    /* Задание 2 */
    @Test
    public void spiedCreatedHumanTest() {
        Reptiloyd testedClass = spy(Reptiloyd.class);
        testedClass.createdHuman();
        verify(testedClass, times(1)).createdHuman(); 
    }

    /* Задание 3 */
    @Test(expected = LimitedCloneException.class)
    public void testedMethodTest() throws LimitedCloneException {
        Reptiloyd testedClass = mock(Reptiloyd.class);
        testedClass.createdHuman();
        when(testedClass.cloneHuman()).thenThrow(new LimitedCloneException("Limited clone"));
        testedClass.cloneHuman();
    }

    /* Задание 4 */
    @Test
    public void privateMethodTest() throws Exception {
        Reptiloyd reptiloyd = new Reptiloyd();
        Method method = Reptiloyd.class.getDeclaredMethod("getHp");
        method.setAccessible(true);
        assertEquals(10000, (int) method.invoke(reptiloyd));
    }

}
