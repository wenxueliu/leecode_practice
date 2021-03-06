


* Dijkstra: 最经典的单源最短路径算法
* bellman-ford: 允许负权边的单源最短路径算法
* SPFA: 其实是bellman-ford+队列优化,其实和bfs的关系更密一点
* Floyd: 经典的多源最短路径算法


### Floyd算法原理

Floyd算法是一个经典的动态规划算法，它又被称为插点法。该算法名称以创始人之一、1978年图灵奖获得者、斯坦福大学计算机科学系教授罗伯特·弗洛伊德命名。Floyd算法是一种利用动态规划的思想寻找给定的加权图中多源点之间最短路径的算法,算法目标是寻找从点i到点j的最短路径。

从任意节点i到任意节点j的最短路径不外乎2种可能，1是直接从i到j，2是从i经过若干个节点k到j。所以，算法假设Dis(i,j)为节点u到节点v的最短路径的距离，对于每一个节点k，算法检查Dis(i,k) + Dis(k,j) < Dis(i,j)是否成立，如果成立，证明从i到k再到j的路径比i直接到j的路径短，便设置Dis(i,j) = Dis(i,k) + Dis(k,j)，这样一来，当遍历完所有节点k，Dis(i,j)中记录的便是i到j的最短路径的距离。

### Floyd算法的基本思想：

可以将问题分解:
第一、先找出最短的距离
第二、然后在考虑如何找出对应的行进路线。
如何找出最短路径呢，这里还是用到动态规划的知识，对于任何一个城市而言，i到j的最短距离不外乎存在经过i与j之间经过k和不经过k两种可能，所以可以令k=1，2，3，...，n(n是城市的数目)，在检查d(ij)与d(ik)+d(kj)的值；在此d(ik)与d(kj)分别是目前为止所知道的i到k与k到j的最短距离，因此d(ik)+d(kj)就是i到j经过k的最短距离。所以，若有d(ij)>d(ik)+d(kj)，就表示从i出发经过k再到j的距离要比原来的i到j距离短，自然把i到j的d(ij)重写为d(ik)+d(kj)，每当一个k查完了，d(ij)就是目前的i到j的最短距离。重复这一过程，最后当查完所有的k时，d(ij)里面存放的就是i到j之间的最短距离了。


Floyd算法的基本步骤：
定义n×n的方阵序列D-1, D0 , … Dn－1,

初始化： D-1＝C

D-1[i][j]＝边<i,j>的长度，表示初始的从i到j的最短路径长度，即它是从i到j的中间不经过其他中间点的最短路径。
迭代：设Dk-1已求出，如何得到Dk（0≤k≤n-1）？

Dk-1[i][j]表示从i到j的中间点不大于k-1的最短路径p：i…j，
考虑将顶点k加入路径p得到顶点序列q：i…k…j，
若q不是路径，则当前的最短路径仍是上一步结果：Dk[i][j]= Dk－1[i][j]；
否则若q的长度小于p的长度，则用q取代p作为从i到j的最短路径
因为q的两条子路径i…k和k…j皆是中间点不大于k－1的最短路径，所以从i到j中间点不大于k的最短路径长度为：
Dk[i][j]＝min{ Dk-1[i][j], Dk-1[i][k] +Dk-1[k][j] }


### 理解的核心

刚开始看 Floyd 看似理解了，但感觉还是没有那么理解。这种感觉应该是第一次看到
这个算法的感觉。后来看到这个算法有个别名叫插点法。

下面我来谈谈自己的理解

以 4 个节点为例

初始值 f[1][4] = 10

在上面所有节点插入节点 2

新的值 f[1][4] = min(f[1,4], f[1,2,4])

在上面所有节点插入节点 3

新的值 f[1][4] = min(f[1,4], min(f[1,3,2], f[1,2]) + min(f[2,4], f[2,3,4])

以此类推
 
### 参考
 
https://www.jianshu.com/p/f73c7a6f5a53
