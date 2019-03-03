import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestQue02 {

    @Test
    public void checkPalindrome(){
        //case 1
        List<List<Integer>> res1 = Que02.sumZero(new int[]{-4,-2,-1,0,1,3,4});
        List<List<Integer>> ans1 = new ArrayList<List<Integer>>();
        ans1.add(new ArrayList<Integer>(Arrays.asList(-4,0,4)));
        ans1.add(new ArrayList<Integer>(Arrays.asList(-4,1,3)));
        ans1.add(new ArrayList<Integer>(Arrays.asList(-2,-1,3)));
        ans1.add(new ArrayList<Integer>(Arrays.asList(-1,0,1)));
        assertArrayEquals(res1.toArray(), ans1.toArray());
        assertEquals(res1,ans1);

        // case 2
        List<List<Integer>> res2 = Que02.sumZero(new int[]{-1,0,1,2,-1,-4});
        List<List<Integer>> ans2 = new ArrayList<List<Integer>>();
        ans2.add(new ArrayList<Integer>(Arrays.asList(-1,-1,2)));
        ans2.add(new ArrayList<Integer>(Arrays.asList(-1,0,1)));
        assertArrayEquals(res2.toArray(), ans2.toArray());
        assertEquals(res2,ans2);
    }

}
