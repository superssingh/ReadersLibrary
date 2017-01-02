google.books.load();

        function alertNotFound() {
          alert("could not embed the book!");
        }

        function initialize(val) {
            var viewer = new google.books.DefaultViewer(document.getElementById('viewerCanvas'));
            <!--var key = Android.getValue();-->
            <!--var key='ISBN:0738531367';-->
            viewer.load(val, alertNotFound);
        }

google.books.setOnLoadCallback(initialize);