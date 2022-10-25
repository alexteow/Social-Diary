package SocialDiary;

public class Diary {
        static private String title;
        static private String date;
        static private String post;

        public Diary(String title, String date, String post){
            this.title=title;
            this.date=date;
            this.post=post;
        }
        public Diary(){

        }

        public String getTitle(){
            return title;
        }
        public void setTitle(String title){
            this.title=title;
        }
        public String getDate(){
            return date;
        }
        public void setDate(String date){
            this.date=date;
        }
        public String getPost(){
            return post;
        }
        public void setPost(String post){
            this.post=post;
        }

        public String toString(){
            return
                    "Title is: " + this.getTitle() +
                            " Date: " + this.getDate() +
                            " Post : " + this.getPost();
        }



    }
