package com.xmut.pmserver.tes;

public class Test {
    public static void main(String[] args) {
      String testJson = "{\n" +
                "\t\"code\": 1000,\n" +
                "\t\"message\": \"查看评论成功\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"total\": 3,\n" +
                "\t\t\"list\": [{\n" +
                "\t\t\t\t\"id\": 42,\n" +
                "\t\t\t\t\"nickName\": \"程序猿\",\n" +
                "\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
                "\t\t\t\t\"content\": \"时间是一切财富中最宝贵的财富。\",\n" +
                "\t\t\t\t\"imgId\": \"xcclsscrt0tev11ok364\",\n" +
                "\t\t\t\t\"replyTotal\": 1,\n" +
                "\t\t\t\t\"createDate\": \"三分钟前\",\n" +
                "\t\t\t\t\"replyList\": [{\n" +
                "\t\t\t\t\t\"nickName\": \"沐風\",\n" +
                "\t\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
                "\t\t\t\t\t\"id\": 40,\n" +
                "\t\t\t\t\t\"commentId\": \"42\",\n" +
                "\t\t\t\t\t\"content\": \"时间总是在不经意中擦肩而过,不留一点痕迹.\",\n" +
                "\t\t\t\t\t\"status\": \"01\",\n" +
                "\t\t\t\t\t\"createDate\": \"一个小时前\"\n" +
                "\t\t\t\t}]\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"id\": 41,\n" +
                "\t\t\t\t\"nickName\": \"设计狗\",\n" +
                "\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
                "\t\t\t\t\"content\": \"这世界要是没有爱情，它在我们心中还会有什么意义！这就如一盏没有亮光的走马灯。\",\n" +
                "\t\t\t\t\"imgId\": \"xcclsscrt0tev11ok364\",\n" +
                "\t\t\t\t\"replyTotal\": 1,\n" +
                "\t\t\t\t\"createDate\": \"一天前\",\n" +
                "\t\t\t\t\"replyList\": [{\n" +
                "\t\t\t\t\t\"nickName\": \"沐風\",\n" +
                "\t\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
                "\t\t\t\t\t\"commentId\": \"41\",\n" +
                "\t\t\t\t\t\"content\": \"时间总是在不经意中擦肩而过,不留一点痕迹.\",\n" +
                "\t\t\t\t\t\"status\": \"01\",\n" +
                "\t\t\t\t\t\"createDate\": \"三小时前\"\n" +
                "\t\t\t\t}]\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"id\": 40,\n" +
                "\t\t\t\t\"nickName\": \"产品喵\",\n" +
                "\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
                "\t\t\t\t\"content\": \"笨蛋自以为聪明，聪明人才知道自己是笨蛋。\",\n" +
                "\t\t\t\t\"imgId\": \"xcclsscrt0tev11ok364\",\n" +
                "\t\t\t\t\"replyTotal\": 0,\n" +
                "\t\t\t\t\"createDate\": \"三天前\",\n" +
                "\t\t\t\t\"replyList\": []\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "}";

        System.out.println(testJson);
    }
}
