import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import ByAnimalTypeView from '../views/ByAnimalTypeView.vue'
import VolunteerView from '../views/VolunteerView.vue'
import AboutUsView from '../views/AboutUsView.vue'
import FormApprovalView from '../views/FormApprovalView.vue'
import Relinquish from '../views/Relinquish.vue'
import VolunteerApplicationView from '../views/VolunteerApplicationView.vue'
import AnimalDetail from '../views/AnimalDetailView.vue'
import LoginUpdate from '../views/UpdateLoginView.vue'
import ByAnimalTypeListView from '@/views/ByAnimalTypeListView'
import AdoptionSuccessView from '../views/AdoptionSuccessView.vue'




Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/relinquish',
            name: 'relinquish',
            component: Relinquish,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: '/',
            name: 'home',
            component: Home,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: '/about',
            name: 'about',
            component: AboutUsView,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: '/animals',
            name: 'animals',
            component: ByAnimalTypeView,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: '/relinquish',
            name: 'relinquish',
            component: Relinquish,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/login",
            name: "login",
            component: Login,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/logout",
            name: "logout",
            component: Logout,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/register",
            name: "register",
            component: Register,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/volunteer",
            name: "volunteer",
            component: VolunteerView,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/volunteer-requests",
            name: "volunteer-requests",

            component: FormApprovalView,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/volunteers/:volunteer_id",
            name: "volunteer-application-form",

            component: VolunteerApplicationView,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/animals/:id",
            name: "animal-detail",

            component: AnimalDetail,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/login/update",
            name: "loginUpdate",
            component: LoginUpdate,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/adoption-success",
            name: "adoptionSuccess",
            component: AdoptionSuccessView,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/animals/type/:id",
            name: "ByTypeList",
            component: ByAnimalTypeListView,
            meta: {
                requiresAuth: false
            }
        }
    ]
})

// function checkAdminRights(to, from, next) {
//     // check if the user is admin
//     if(userIsAdmin) {
//         next({ path: '/volunteer-requests'});       
//     } else {
//         next({ path: '/home'});
//     }
// }

router.beforeEach((to, from, next) => {
    // Determine if the route requires Authentication
    const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

    // If it does and they are not logged in, send the user to "/login"
    if (requiresAuth && store.state.token === '') {
        next("/login");
    } else if (store.state.user.passwordNeedsChanged === true && to.name !== "loginUpdate") {
        store.commit('CLEAR_PASSWORD_REQUIRED');
        next("/login/update");
    } else {
        // Else let them go to their next destination
        next();
    }
});

export default router;
