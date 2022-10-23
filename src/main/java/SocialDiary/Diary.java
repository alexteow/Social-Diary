package SocialDiary;

public class Diary {
        private String name;
        private String title;
        private String date;
        private String post;

        public Diary(String name, String title, String date, String post){
            this.name=name;
            this.title=title;
            this.date=date;
            this.post=post;
        }
        public Diary(){

        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
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
