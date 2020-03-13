package pojo;
public class BinaryTree{
    class Node{          //����һ���ڵ���
        private Comparable data;  //�ڵ����������ΪComparable
        private Node left;   //����������
        private Node right;  //����������
        public Node(Comparable data){   //���캯��
            this.data = data;
        }
        public void addNode(Node newNode){
            //ȷ���Ƿ�������������������
            if(newNode.data.compareTo(this.data)<0){  //�½ڵ�ֵС�ڵ�ǰ�ڵ�
                if(this.left == null){
                    this.left = newNode;  //������Ϊ�յĻ����½ڵ���Ϊ������
                }else{
                    this.left.addNode(newNode); //������������ж�
                }
            }else{  //�½ڵ��ֵ���ڻ���ڵ�ǰ�ڵ�
                if(this.right == null){
                    this.right = newNode;
                }else{
                    this.right.addNode(newNode);
                }
            }
        }
        
        public void printNode(){  //�����������
            if(this.left != null){   //�����Ϊ�������������
                this.left.printNode();
            }
            System.out.print(this.data+"\t");  //�����ǰ���ڵ�
            if(this.right != null){  //���������
                this.right.printNode();  
            }
        }
    }
    private Node root;    //��ʾ��Ԫ��
    
    public void add(Comparable data){    //��������в���Ԫ��
        Node newNode = new Node(data);
        if(root == null){   //û�и��ڵ�
            root = newNode;
        }else{
            root.addNode(newNode); //�жϷ�������������������
        }
    }
    
    public void print(){
        root.printNode();   //���ݸ��ڵ����
    }
}


