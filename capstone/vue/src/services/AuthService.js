import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  registerDualKey(userId, volunteerId) {
    return axios.post(`/volunteer-user`, userId, volunteerId);
  },

  getVolunteerIdByUserId(userId) {
    return axios.get(`/volunteer-user/user/${userId}`);
  },

  getUserIdByVolunteerId(volunteerId) {
    return axios.get(`/volunteer-user/volunteer/${volunteerId}`);
  }
}
