<template>
    <v-container>
        <v-card class="pa-3 ">
          <!-- <v-btn  router :to="{name:'boardwrite'}">글쓰기</v-btn> -->
            <v-list three-line>
              <template v-for="(item) in boardlist">
               
                <v-list-item
                  :key="item.bId"
                  @click="boardDetail(item.bId)"
                >
                  <v-list-item-content >
                    <v-list-item-subtitle v-html="item.bTitle"></v-list-item-subtitle>
                    <v-list-item-subtitle v-html="item.bContent"></v-list-item-subtitle>
                  </v-list-item-content>
                </v-list-item>
              </template>
            </v-list>
        </v-card>
    </v-container>
</template>
<script>
import { mapState, mapActions } from "vuex"
export default {
  created() {
    this.$store.dispatch('boardList')
  },
  computed: {
    ...mapState(["boardlist"])
  },
  methods: {
    ...mapActions(['boardDetail','boardWrite'])
  }
}
</script>