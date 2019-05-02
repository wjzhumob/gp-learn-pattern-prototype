package com.gp.learn.pattern.prototype;

/**
 * @author wjzhu
 * @createDate 2019-05-02 21:17
 */
public class DeepCloneTest {
    public static void main(String[] args) {
        Novel novel = new Novel();
        novel.setContent("1");
        novel.setDescription("2");
        novel.setNote(new Note());
        novel.setHeight(3);
        novel.setWidth(4);
        novel.setPage(5);

        try {
            Novel clone = (Novel) novel.clone();
            Novel clone2 = (Novel) novel.clone();
            System.out.println("深克隆：" + (novel.note== clone.note));
            System.out.println("深克隆：" + (clone2 == clone));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
