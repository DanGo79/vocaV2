<template>
  <div class="container p-5">
    <table class="table table-bordered table-hover">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in xmlItems" :key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td>{{ item.email }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
//importing bootstrap 5 Modules
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import xml2js from "xml2js";
export default {
  mounted() {
    //xml file calling
    console.log("test/user.xml");
    axios.get("test/user.xml").then((response) => {
      this.parseXML(response.data).then((data) => {
        this.xmlItems = data;
      });
    });
  },
  methods: {
    //xml file data parsing
    parseXML(data) {
      return new Promise((resolve) => {
        var k = "";
        var arr = [],
          parser = new xml2js.Parser({
            trim: true,
            explicitArray: true,
          });
        parser.parseString(data, function (err, result) {
          var obj = result.Employee;
          for (k in obj.emp) {
            var item = obj.emp[k];
            arr.push({
              id: item.id[0],
              name: item.name[0],
              email: item.email[0],
            });
          }
          resolve(arr);
        });
      });
    },
  },
  data: function () {
    return {
      xmlItems: [],
    };
  },
};
</script>