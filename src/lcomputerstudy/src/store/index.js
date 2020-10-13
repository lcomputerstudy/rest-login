import Vue from 'vue'
import Vuex from 'vuex'
import Route from '../router/index'
import axios from 'axios'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    Userinfo:{User_Id:null,User_Name:null,User_auth:[]},
    login_err:false,
    login_success:false,
    boardlist:[],
    board_detail:[]
  },
  getters: {
    allUsers: state=> {
      return state.UserList.length
    }
  },
  mutations: {
    NewUsers: (state,payload) => {
      state.UserList.push(payload)
      Route.push("/login")
    },
    // Login:(state,payload) => {
    //   let LoginUser = null
    //   state.UserList.forEach(user => {
    //     if(user.UserId === payload.Login_Id) {
    //       LoginUser = user
    //     }
    //   })
    //   if(LoginUser === null) {
    //     state.login_err=true
    //     state.login_success=false
    //   }
    //   else {
    //     if(LoginUser.UserPassword !== payload.Login_Password) {
    //       state.login_err=true
    //       state.login_success=false
    //     } else {
    //       state.login_success=true
    //       state.login_err=false
    //       state.Userinfo=state.UserList.find(c => c.UserId===payload.Login_Id)
    //       //console.log(state.Userinfo)
    //       Route.push("/user")
    //     }
    //   }
    // }
    SET_USER(state, data) {
      state.Userinfo.User_Id = data.username
      state.Userinfo.User_Name = data.name
      state.Userinfo.User_auth = data.authorities
      Route.push("/user")
   },
   SET_BOARDLIST(state,data) {
     state.boardlist = data
   },
   SET_BOARDDETAIL(state,data) {
     state.board_detail=data
     Route.push("/boardDetail/"+data.bId)
   },
   SET_BOARDDELETE(state,data) {
     var index = state.boardlist.findIndex(i => i.bId == data);
     state.boardlist.splice(index, 1);
     Route.push("/boardlist")
   }
  },
  actions: {
    // NewUsers: ({commit}, payload) => {
    //   commit('NewUsers',payload)
    // },
    // Login({commit}, payload) {
    //   commit("Login",payload)
    // },
    loginProcess({ commit }, payload) {
      console.log(payload)
      return new Promise((resolve, reject) => {
          axios.post('http://localhost:9000/api/auth/signin', payload)
              .then(Response => {
                  console.log(Response.data)
                  if (Response.data.username != null) {
                      axios.defaults.headers.common['Authorization'] = `Bearer ${Response.data.token}`
                      localStorage.setItem("token",Response.data.token)
                      commit('SET_USER', Response.data)
                      
                  }
              })
              .catch(Error => {
                  console.log('error')
                  reject(Error)
              })
      })
   },
   SignUp({commit},payload) {
    console.log(payload)
    return new Promise((resolve, reject) => {
        axios.post('http://localhost:9000/api/auth/signup', payload)
            .then(Response => {
                console.log(Response.data)
                if(Response.data === "success") {
                  Route.push("/login")
                }
            })
            .catch(Error => {
                console.log('error')
                reject(Error)
            })
    })
   },
   boardList({commit}) {
    return new Promise((resolve, reject) => {
        axios.get('http://localhost:9000/api/test/user')
            .then(Response => {
                console.log(Response.data)
                commit('SET_BOARDLIST', Response.data)
            })
            .catch(Error => {
                console.log('error')
                reject(Error)
            })
    })
   },
   boardDetail({commit},payload) {
    return new Promise((resolve, reject) => {
      axios.get('http://localhost:9000/api/test/boardDetail', {
        params: {
          bId: payload
        }
      })
          .then(Response => {
              console.log(Response.data)
              commit('SET_BOARDDETAIL', Response.data)
          })
          .catch(Error => {
              console.log('error')
              reject(Error)
          })
    })
   },

  BoardDelete({commit},payload) {
    console.log(payload)
    return new Promise((resolve, reject) => {
      axios.delete('http://localhost:9000/api/test/boardDelete/'+payload.bId)
          .then(Response => {
              console.log(Response.data)
              commit('SET_BOARDDELETE', Response.data)
          })
          .catch(Error => {
              console.log('error')
              reject(Error)
          })
   })
  },
  boardWrite({commit},payload) {
    return new Promise((resolve, reject) => {
      axios.post('http://localhost:9000/api/test/boardWrite', payload)
          .then(Response => {
              console.log(Response.data)
              if(Response.data === "success") {
                commit('SET_BOARDWRITE', Response.data)
              }
          })
          .catch(Error => {
              console.log('error')
              reject(Error)
          })
  })
  },
  admin({commit}) {
    let token = localStorage.getItem("token")
    console.log(token)
    return new Promise((resolve, reject) => {
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
      axios.get('http://localhost:9000/api/admin/adminPage')
          .then(Response => {
            console.log(Response)
          })
          .catch(Error => {
            console.log(Error)
              console.log('admin_error')
              Route.push("/home")
          })
  })
  }
}
})