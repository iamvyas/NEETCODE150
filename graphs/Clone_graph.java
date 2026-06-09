class Solution {

    private Map<Node, Node> visitedNodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
        
    }

    Node dfs(Node node){
        if(node == null )return null;
        Node cnode = visitedNodes.get(node); //should be outside if cause to return for both null and not null cases
        if(cnode==null){
            cnode = new Node();
            cnode.val = node.val;
            visitedNodes.put(node, cnode);
            for(Node x : node.neighbors ){
                cnode.neighbors.add(dfs(x));
            }    
        }
        

        return cnode;
    }
}