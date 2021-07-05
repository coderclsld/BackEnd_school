package clsld.util;

import java.util.ArrayList;
import java.util.List;
import clsld.entity.comment;
public class TreeUtil {
    /**
     * 把评论信息的集合转化为一个树
     */
    public List<CommentNode> buildTree(List<comment> commentInfo, Integer id){
        //   Node tree = new Node();                  //Tree头结点
        List<CommentNode> children = new ArrayList<>();
        List<CommentNode> nodeList = new ArrayList<>();
        for (comment info : commentInfo) {  //把每一个评论信息转换成节点node,填入children节点集合
            children.add(buildNode(info));
        }
        System.out.println(children);
        //     tree.setId(id);
        //     tree.setChildren(children);         //Tree的children指向  chiledren节点集合

        for (CommentNode child : children) {
            System.out.println(child.getParent_id());
            CommentNode node = findNode(children, child.getParent_id()); //查找每一个节点的父节点·
            List<CommentNode> nodes = new ArrayList<>();

            if (node != null) { //父节点不为空

                if (node.getChildren() != null) {  //添加下一级评论中的同级评论(兄弟节点)
                    nodes = node.getChildren();
                    nodes.add(child);
                    node.setChildren(nodes);
                }else {                         //父级节点的第一个子节点
                    nodes.add(child);
                    node.setChildren(nodes);
                }
                nodeList.add(child);  //nodeList用来记录二级评论的(二级评论的父节点不为空)
            }
        }
        for (CommentNode node : nodeList) { //在children中清除二级评论
            children.remove(node);
        }

        //return tree;
        return children;
    }

    private CommentNode findNode(List<CommentNode> nodes, Integer id){
        for (CommentNode node : nodes) {
            if (node.getComment_id() == id) {
                return node;
            }
        }
        return null;
    }

    private CommentNode buildNode(comment info){
        CommentNode node = new CommentNode();
        node.setComment_id(info.getComment_id());
        node.setParent_id(info.getParent_id());
        node.setAnswer_id(info.getAnswer_id());
        node.setContent(info.getContent());
        node.setUserid(info.getUserid());
        node.setUsername(info.getUsername());
        node.setChildren(null);
        node.setAvatar_url(info.getAvatar_url());
        node.setParent_name(info.getParent_name());

        return node;
    }

}
