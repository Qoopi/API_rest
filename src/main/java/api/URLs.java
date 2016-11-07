package api;
//ceeeeeeeeeeeeeeeeeeeeeeeeeeeee

   public enum URLs {

        LOGIN("/rest/auth/1/session"),
        ISSUE("/rest/api/2/issue"),
        PASSWORD("/rest/api/2/myself/password"),
        FILTER("/rest/api/2/filter"),
        SEARCH("/rest/api/2/search");
        private String uri;

        URLs(String url) {
            this.uri = url;
        }

        public String getUri(){
            return this.uri;
        }

        public String getUri(String key){
            return this.uri + "/" + key;
        }
   }