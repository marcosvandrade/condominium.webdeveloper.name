import Vue from 'vue'

export const userKey = '__knowledge_user'
export const baseApiUrl = 'http://ec2-18-206-252-75.compute-1.amazonaws.com:4001'
// export const baseApiUrl = 'http://localhost:4001'

export function showError(e) {
    if(e && e.response && e.response.data) {
        Vue.toasted.global.defaultError({ msg : e.response.data })
    } else if(typeof e === 'string') {
        Vue.toasted.global.defaultError({ msg : e })
    } else {
        Vue.toasted.global.defaultError()
    } 
}

export default { baseApiUrl, showError, userKey }