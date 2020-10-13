<template>
<v-container style="max-width:500px">
    <v-layout>
        <v-flex xs12>

            <v-card class="elevation-12">
                <v-toolbar
                color="primary"
                dark
                flat
                >
                <v-toolbar-title>
                    Login
                </v-toolbar-title>
                <v-spacer></v-spacer>
                </v-toolbar>
                <v-card-text>
                <v-form>
                    <v-text-field
                    label="ID"
                    name="username"
                    v-model="username"
                    prepend-icon="mdi-account"
                    type="text"
                    ></v-text-field>

                    <v-text-field
                    id="Password"
                    label="Password"
                    v-model="password"
                    name="password"
                    prepend-icon="mdi-lock"
                    type="password"
                    ></v-text-field>
                </v-form>
                </v-card-text>
                <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="primary" @click="login({username: username, password: password})">Login</v-btn>
                <v-btn color="#ECEFF1" router :to="{name:'SignUp'}">Sign Up</v-btn>
                </v-card-actions>
            </v-card>
        </v-flex>
    </v-layout>
</v-container>
</template>

<script>
import {mapActions,mapState} from "vuex"
  export default {
    data() {
      return {
        username:null,
        password:null,
      }
    },
    computed: {
      ...mapState(["Userinfo"])
    },
    methods: {
   // ...mapActions(["Login"])
    login(payload) {
        this.$store.dispatch('loginProcess', payload)
    }
  }
}
</script>