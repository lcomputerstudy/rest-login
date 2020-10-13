<template>
    <div>
        <h1>회원리스트</h1>
        <table>
          <tr>
            <td>Id</td>
            <td>name</td>
            <td>phone</td>
          </tr>
          <!-- <tr>
            <td>{{UserList.name}}</td>
          </tr> -->
          
        </table>
    </div>
</template>
<script>
import { mapState, mapActions } from "vuex"
export default {
  created() {
    this.$store.dispatch('admin')
  }
  // computed: {
  //     ...mapState(["UserList"])
  // }
}
</script>