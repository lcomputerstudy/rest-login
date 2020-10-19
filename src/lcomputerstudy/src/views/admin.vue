<template>
    <div>
        <h1>회원리스트</h1>
        <table>
          <tr style="font-weight:900;">
            <td>ID</td>
            <td>NAME</td>
            <td>PHONE</td>
            <td>AUTH</td>
          </tr>
         <tr v-for="(item, i) in UserList" :key="i">
           <td>{{item.username}}</td>
           <td>{{item.name}}</td>
           <td>{{item.phone}}</td>
           <td>
            <span v-for="(items, index) in item.authorities" :key="index">
              {{items.authority}}
            </span>
           </td>
           <!-- <td>
             {{item.authorities[0].authority}}
           </td> -->
           
         </tr>
        </table>
    </div>
</template>
<style scoped>
div {
  width:100%;
  height:100%;
  text-align: center;
}
  table {
    width:400px;
    margin:50px auto;
    border-collapse:collapse;
    text-align: center;
  }
  table tr td {
    border:1px solid #818181;
    padding:5px;
  }
</style>
<script>
import { mapState, mapActions } from "vuex"
export default {
  created() {
    this.$store.dispatch('admin')
  },
  computed: {
      ...mapState(["UserList"])
  }
}
</script>