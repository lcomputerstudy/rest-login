<template>
    <v-flex xs12 style="text-align:center">
        <h1>{{Userinfo.User_Name}}님 환영합니다.</h1>
    </v-flex>
</template>
<script>
import {mapState} from "vuex"

export default {
    computed: {
        ...mapState(["Userinfo"])
    }
}
</script>