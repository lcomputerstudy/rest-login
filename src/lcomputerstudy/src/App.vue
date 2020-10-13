<template>
  <v-app id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <v-list dense>
        <v-list-item router :to="{name:'Login'}">
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Login</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item router :to="{name:'BoardList'}">
          <v-list-item-action>
            <v-icon>mdi-card-text-outline</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>게시판</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
         <v-list-item router :to="{name:'admin'}">
          <v-list-item-action>
            <v-icon>mdi-card-text-outline</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>관리자</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      color="primary"
      dark
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>LcomputerStudy</v-toolbar-title>
      <v-btn>로그아웃</v-btn>
    </v-app-bar>

    <v-main>
      <v-container
        class="fill-height"
        fluid
      >
        <router-view/>
      </v-container>
    </v-main>
    <v-footer
      color="primary"
      app
    >
      <span class="white--text">&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
import {mapMutations, mapState} from "vuex"

  export default {
    data: () => ({
      drawer: null,
    }),
    computed: {
      ...mapState(["Userinfo"])
    },
    // methods: {
    //   ...mapMutations(["INSERT_TOKEN"])
    // },
    created() {
      if(this.Userinfo.User_token === null) {
        this.$store.commit("INSERT_TOKEN")
        console.log("tttttt"+this.Userinfo.User_token)
      }
    }
  }
</script>