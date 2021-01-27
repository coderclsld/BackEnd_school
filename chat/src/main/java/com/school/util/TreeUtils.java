package com.school.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZKJ
 * @create 2020-12-07 0:24
 */
public class TreeUtils {
    /**
     * 把评论信息的集合转化为一个树
     */
    public List<Node> buildTree(List<CommentInfo> commentInfo, Integer id){
        //   Node tree = new Node();                  //Tree头结点
        List<Node> children = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
        for (CommentInfo info : commentInfo) {  //把每一个评论信息转换成节点node,填入children节点集合
            children.add(buildNode(info));
        }
        System.out.println(children);
        //     tree.setId(id);
        //     tree.setChildren(children);         //Tree的children指向  chiledren节点集合

        for (Node child : children) {
            System.out.println(child.getParentId());
            Node node = findNode(children, child.getParentId()); //查找每一个节点的父节点·
            List<Node> nodes = new ArrayList<>();

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
        for (Node node : nodeList) { //在children中清除二级评论
            children.remove(node);
        }

        //return tree;
        return children;
    }

    private Node findNode(List<Node> nodes, Integer id){
        for (Node node : nodes) {
            if (node.getId() == id) {
                return node;
            }
        }
        return null;
    }

    private Node buildNode(CommentInfo info){
        Node node = new Node();
        node.setId(info.getId());
        node.setParentId(info.getParentId());
        node.setArticleId(info.getArticleId());
        node.setContent(info.getContent());
        node.setStatus(info.getStatus());
        node.setUserId(info.getUserId());
        node.setUserNickName(info.getUserNickName());
        node.setChildren(null);

        return node;
    }

}
