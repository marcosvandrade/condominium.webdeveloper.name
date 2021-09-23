import Vue from 'vue'

export const userKey = '__knowledge_user'
// export const baseApiUrl = 'http://my-loadbalancer-763909654.us-east-1.elb.amazonaws.com:4001'
// export const baseApiUrl = 'http://34.203.91.20:4001'
export const baseApiUrl = 'http://localhost:4001'

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
