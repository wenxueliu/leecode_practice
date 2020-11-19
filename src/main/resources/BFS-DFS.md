
## BFS 和 DFS

求最大值用 DFS，求最小值用 BFS

#### 如果不需要确定当前遍历到了哪一层

while queue 不空：
    cur = queue.pop()
    for 节点 in cur的所有相邻节点：
        if 该节点有效且未访问过：
            queue.push(该节点)


#### 如果要确定当前遍历到了哪一层

这里增加了 level 表示当前遍历到二叉树中的哪一层了，也可以理解为在一个图中，现在已经走了多少步了。size 表示在当前遍历层有多少个元素，也就是队列中的元素数，我们把这些元素一次性遍历完，即把当前层的所有元素都向外走了一步。

int level = 0
while (!queue.isEmpty()) {
    int size = queue.size()
    while (size --) {
        cur = queue.pop()
        for 节点 in cur的所有相邻节点：
            if 该节点有效且未被访问过：
                queue.push(该节点)
    }
    level ++;
}


### 多源最短路径


BFS

核心
1. 结束条件
2. 边界检查

1162
542
310
