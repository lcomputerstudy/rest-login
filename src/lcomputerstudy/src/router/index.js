import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import SignUp from '../views/SignUp.vue'
import BoardList from '../views/BoardList.vue'
import User from '../views/User.vue'
import boardDetail from '../views/boardDetail.vue'
import boardWrite from '../views/boardWrite.vue'
import admin from '../views/admin.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/boardlist',
    name: 'BoardList',
    component: BoardList
  },
  {
    path: '/user',
    name: 'User',
    component: User
  },
  {
    path: '/boardDetail/:bId',
    name: 'boardDetail',
    component: boardDetail
  },
  {
    path: '/boardwrite',
    name: 'boardwrite',
    component:boardWrite
  },

  {
    path: '/admin',
    name: 'admin',
    component:admin
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
