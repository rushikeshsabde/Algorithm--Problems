# Compititions
1) cadburyProblem.py => cadbury problem
   In a School, Chocolate bars have to be distributed to children waiting in a queue. Each Chocolate bar is rectangular in shape. Consider its side lengths are integer values.

The distribution procedure is as follows:-

If bar is not square in shape, then the largest possible square piece of Chocolate is broken and given to the first child in queue. If bar is square in shape, then complete bar is given to the first child in queue. Once a child receives his share of Chocolate, he leaves the queue. The remaining portion of the Chocolate bar is dealt in same fashion and the whole or a portion of it is given to the next child in the queue.

School has got a carton of Chocolate bars to be distributed among the children all over the School. The Chocolate bars in the carton are of different sizes. A bar of length i and breadth j is considered to be different from a bar of length j and breadth i. For every i such that M≤i≤N and every j such that P≤j≤Q (where M, N, P and Q are integers). Each Chocolate bar in carton is unique in length (i) and breath(j).

Given the values of M, N, P and Q (where M, N values are the ranges for length of Chocolate and P, Q values are the ranges for breadth of the chocolate). Find the number of children who will receive Chocolate from the carton.

Input Specification:

M, N, P, Q are of integer type (M, N values are the ranges for length of chocolate bar. P, Q values are the ranges for breadth of chocolate bar).

Output Specification:

Number of children who will receive Cadbury bar from the carton.

M = 5, N = 6, P = 3, Q=4 Here, i can be from 5 to 6 and j can be from 3 to 4. So the four bars will be in carton of sizes 5x3, 5x4, 6x3, 6x4.

First we choose a Cadbury bar of size 5x3 → first child would receive 3x3 portion ( remaining 2x3 portion ) → next child would receive 2x2 portion ( remaining 2x1 portion ) → now the remaining portion are 2 square pieces of (1x1), which can be given to 2 more children

So the Cadbury bar with the size of 5x3 can be distributed to 4 children.

Similarly we can find out number of children for rest of the combinations (i.e. 5x4, 6x3, 6x4) in the given range as follows
